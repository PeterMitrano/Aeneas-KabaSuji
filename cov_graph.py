#!/usr/bin/python
import urllib, json
import pylab
from dateutil import parser
urlbase = "https://codecov.io/api/gh/Cheddarpuffs/Aeneas-Kabasuji/commits/"
initial_commit = "f9b0aa161b198d39da1485ec2c99156fd1a9501b"

def get_commits():
  global urlbase
  url = urlbase+"?limit=200"
  response = urllib.urlopen(url)
  data = json.loads(response.read())
  commits = data["commits"]
  ret = []
  for c in commits:
    ret.append(c["commitid"])
  return ret

def get_file(commit):
  global urlbase
  try:
    response = urllib.urlopen(urlbase+commit)
    data = json.loads(response.read())
    f = data["commit"]["report"]["files"]
    date =data["commit"]["timestamp"]
    date = parser.parse(date)
    print date.date()
  except Exception as e:
    print "Failed on commit "+ commit
    print e
    return None, None, None
  pack_cov = {"models" : [0., 0.],
              "controllers" : [0., 0.],
              "views" : [0., 0.]}
  for key in f.keys():
    try:
      package = key.split('/')[4]
      cov = pack_cov[package]
      file_cov = f[key]["t"]
      cov[0] += file_cov["h"] # hits
      cov[1] += file_cov["n"] # Total
    except: pass
  return pack_cov, date

def get_cov():
  global urlbase
  allcov = {"models" : [[], []],
            "controllers" : [[], []],
            "views" : [[], []]}
  commits = get_commits()
  for c in commits:
    cov, date = get_file(c)
    for key in cov.keys():
      allcov[key][1].append(cov[key][0] / cov[key][1])
      allcov[key][0].append(date)
  print allcov
  return allcov

cov = get_cov()

for key in cov.keys():
  data = cov[key][1]
  dates = cov[key][0]
  pylab.plot(dates, data, label=key)
pylab.legend()
pylab.show()

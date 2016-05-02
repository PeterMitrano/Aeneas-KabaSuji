#!/usr/bin/python
import urllib, json
import pylab
urlbase = "https://codecov.io/api/gh/Cheddarpuffs/Aeneas-Kabasuji/commits/"
initial_commit = "f9b0aa161b198d39da1485ec2c99156fd1a9501b"

def get_file(commit):
  global urlbase
  try:
    response = urllib.urlopen(urlbase+commit)
    data = json.loads(response.read())
    parent = data["commit"]["parent"]
    f = data["commit"]["report"]["files"]
  except:
    return None, None
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
  return pack_cov, parent

def get_cov(icommit):
  global urlbase
  nextc = icommit
  allcov = {"models" : [],
            "controllers" : [],
            "views" : []}
  while True:
    cov, nextc = get_file(nextc)
    if nextc == None or cov == None: break
    for key in cov.keys():
      allcov[key].append(cov[key][0] / cov[key][1])
  print allcov
  return allcov

get_file(initial_commit)
cov = get_cov(initial_commit)

for key in cov.keys():
  data = cov[key]
  data.reverse()
  pylab.plot(range(len(data)), data, label=key)
pylab.legend()
pylab.show()

#!/bin/bash

if [ "$TRAVIS_REPO_SLUG" == "Cheddarpuffs/Aeneas-Kabasuji" ]; then echo "correct repo slug"; fi
if [ "$TRAVIS_JDK_VERSION" == "oraclejdk8" ]; then echo "correct jdk version"; fi
if [ "$TRAVIS_PULL_REQUEST" == "false" ]; then echo "correct PR"; fi
if [ "$TRAVIS_BRANCH" == "master" ]; then echo "correct branch"; fi

if [ "$TRAVIS_REPO_SLUG" == "Cheddarpuffs/Aeneas-Kabasuji" ] && [ "$TRAVIS_JDK_VERSION" == "oraclejdk8" ] && [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_BRANCH" == "master" ]; then

  echo "regenerating javadocs"

  # Get to the Travis build directory, configure git and clone the repo
  #cd $HOME
  #git config --global user.email "travis@travis-ci.org"
  #git config --global user.name "travis-ci"
  #git clone --branch=gh-pages https://${GH_TOKEN}@github.com/CheddarPuffs/Aeneas-Kabasuji gh-pages

  # Commit and Push the Changes
  #cd gh-pages
  #./gradlew javadocs
  #git add --all .
  #git commit -m "Lastest javadoc on successful travis build $TRAVIS_BUILD_NUMBER auto-pushed to gh-pages"
  #git push -f origin gh-pages

  echo -e "Published Javadoc to gh-pages.\n"

fi

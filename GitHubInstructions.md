# GitHub Instructions

## Starting a branch:
```sh
$ git branch
* master
$ git checkout -b new_branch
# Do some work here
$ git add --all .
$ git commit -m "COMMIT MESSAGE HERE"
# For the first push, do this.
$ git push -u origin new_branch
# If you need to push again you can do
$ git push
Create pull request on github.com

```

## Merging branches into master
When you want to merge something for *your* branch into *master*, go onto GitHub and select your branch, then click
*New Pull Request* and create one. Then get someone else to review it, and merge it into master on GitHub.

Its possible that you will need to do the merge on the command line, if merging that branch into master would have merged
conflicts. GitHub will actually provide some instructions to try and guide you through this process, so I won't descibe
it here.

## Getting changes from master
Say you are on a branch called `my_branch`, you have some uncommited changes, but you want to merge master before you continue.

Do this:
```sh
$ git stash -u
# Only line above if your branch has any uncommitted changes
$ git checkout master
$ git pull
$ git checkout my_branch
$ git merge master
$ git stash pop
# Only line above if your branch has any uncommitted changes
$ git log (to check the logs)
```

If that all went well you should be back on `my_branch` with the changes from master merged into your work, and your
work you had uncommited perviously back in its place. Its possible that when unstashing (`git stash pop`) you will
get a merge conflict. You will need to resolve this yourself and then do a `git commit`, which will probably
open Vim (`:wq` to quit).



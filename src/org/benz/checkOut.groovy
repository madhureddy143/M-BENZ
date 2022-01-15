// src/org/benz/checkOut.groovy
package org.benz

def checkOutFrom(repo) {
  git url: "git@github.com:jenkinsci/${repo}"
}

return this

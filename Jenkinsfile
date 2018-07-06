pipeline {
  agent none
  stages {
    stage('deploy-test-env') {
      steps {
        build 'Deploy-TestAPP'
      }
    }
    stage('') {
      steps {
        build 'Test-TestAPP'
      }
    }
  }
  environment {
    env = 'live'
  }
}
pipeline {
  agent none
  stages {
    stage('deploy-test-env') {
      steps {
        build 'Deploy-TestAPP-Dev'
      }
    }
    stage('test-test-env') {
      steps {
        build 'Test-TestAPP'
      }
    }
    stage('deploy-live-env') {
      steps {
        build 'Deploy-TestAPP'
      }
    }
    stage('test-live-env') {
      steps {
        build 'Test-LiveAPP'
      }
    }
  }
  environment {
    env = 'live'
  }
}
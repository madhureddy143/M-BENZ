pipeline{
	agent{
		docker {
			image 'node:16.13.1-alpine'
		}
	}
	stages{
		stage('with docker'){
			steps{
				sh 'node --version'
			}
		}
	}
}
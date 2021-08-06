pipeline{
	agent any
	parameters {
		choice (name: 'Static_Check', choices: ['YES', 'NO'])
		choice (name: 'QA', choices: ['YES', 'NO'])
		choice (name: 'Unit_Test', choices: ['YES', 'NO'])
		string (name: 'Success_Email', defaultValue: 'default@gmail.com')
		string (name: 'Failure_Email', defaultValue: 'failure@gmail.com')
		}
	stages{
		stage('git pull'){
			steps{
				echo "pulling from git"
				}
				}
		stage('is the run required'){
			steps{
				echo "working on rest url"
				}
				}
		stage('Build'){
			steps{
				echo "a conditon to run based on non-holiday days"
				}
				}
		stage('parrel stages'){
			parallel{
				stage('Unit Test'){
					when{
						expression { "${params.Unit_Test}" == 'YES'}
						}
					steps{
						echo "doing unit tests"
						 }
				}
				stage('intermediate'){
					stages{
						stage('static check'){
							when{
								expression { "${params.Static_Check}" == 'YES'}
								}
							steps{
								echo "doing static check"
						    }
				        }
				
						stage('QA'){
							when{
								expression { "${params.QA}" == 'YES'}
								}
							steps{
								echo"doing QA check"
				            }
				        }
				    }
				}
		    }
	    }
		stage('summary'){
			steps{
			echo "final summary"
			}
			}
	}
}
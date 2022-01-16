pipeline{
	agent any
	parameters {
		booleanParam(name: 'STATIC_CHECK', defaultValue: true )
		booleanParam (name: 'QA', defaultValue: true)
		booleanParam (name: 'Unit_Test', defaultValue: true)
		string (name: 'Success_Email', defaultValue: 'success@gmail.com')
		string (name: 'Failure_Email', defaultValue: 'failure@gmail.com')
	}
	
	stages{
		stage('git pull'){
			steps{
				git branch: 'main',
				url: 'https://github.com/madhureddy143/M-BENZ.git'
				echo "pulling from git"
				}
				}
		stage('is the run required'){
			steps{
				echo "is it required"
				}
				}
		stage('Build'){
			steps{
				echo "a conditon to run based on non-holiday days"
				}
				}
		stage ('parallel stage'){
			parallel{
				stage('sequentail starts'){
					stages{
						stage('static check'){
							when{
								expression { "${params.Static_Check}" == true}
								}
							steps{
								fileOperations([folderCreateOperation('static check')])
								echo "doing static check"
							}
						}
						stage('QA'){
							when{
								expression { "${params.QA}" == true}
								}
							steps{
								fileOperations([folderCreateOperation('QA')])
								echo"doing QA check"
									}
						}
				    }
				}
				stage('Unit Test'){
					when{
						expression { "${params.Unit_Test}" == true}
						}
					steps{
						fileOperations([folderCreateOperation('Unit Test')])
						echo "doing unit tests"
						}
				
				}
		       }
        }				
		stage('summary'){
			steps{
				script{
				    if ("${STATIC_CHECK}" == true){
					println("Successfully ran Static_Check block")
					} else {
						println("didn't do the Static Checks")
						}
				
					if ("${QA}" == true){
					println("Successfully RAN the QA checks")
					} else {
						println("didn't do the QA checks")
						}
						
					if ("${Unit_Test}" == true){
					println("Successfully RAN the Unit_Test checks")
					} else {
						println("didn't do the unit_test checks")
						}
				}		
			echo "final summary"
			}
		}
	}
    post {
		success {
			emailext body: '''Dear Team,

                        please find below build success mail''', subject: 'build success mail', to: "${params.Success_Email}",
						from : 'noreply-build@gmail.com'
		}
		failure {
			emailext body: '''Dear Team,

                        please find below build failure mail''', subject: 'build failure mail', to: "${params.Failure_Email}",
						from : 'noreply-build@gmail.com'
		}
		
    }		
}
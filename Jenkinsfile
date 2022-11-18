
pipeline {
    agent any

    stages {

       stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "main", 
                    url: "https://github.com/hamed46/Exam.git"
            }
        }


        stage('MVN CLEAN') {
            steps {
                sh 'mvn clean'
            }
        }
        
        stage('MVN INSTALL') {
            steps {
                sh 'mvn install'
            }
        }
        
        stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
            }
        }
        
        stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
        
        stage('Junit') {
            steps {
                sh 'mvn clean test -Dtest=tn.esprit.CallRestWebService -DfailIfNoTests=false'
            }
         
         }
        
        stage('NEXUS') {
            steps {
                sh 'mvn deploy'// -DskipTests'
                /* artifacts: [
                    [
                        artifactId: 'Exam', 
                        classifier: '', 
                        file: 'target/Exam-1.0.jar', 
                        type: 'jar'
                        ]
                        ], 
                credentialsId: 'deploymentRepo', 
                groupId: 'tn.esprit', 
                nexusUrl: '172.10.0.140:8081', 
                nexusVersion: 'nexus3', 
                protocol: 'http', 
                repository: 'demoapp-release', 
                version: '1.0'*/
            }
        }
        
        stage('Docker build')
        {
            steps {
                 sh 'docker build -t nzex/alpine .'

            }
         
        }
        
        stage('Docker login')
        {
            steps {
                sh 'echo $dockerhub_PSW | docker login -u nzex -p thedance46'
            }    
       
        }
        
        stage('Push Project') {

			steps {
				sh 'docker push nzex/alpine'

			}
        }

    }
}

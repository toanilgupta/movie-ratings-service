pipeline{
    agent any

    stages{
        stage('Build Stage'){
            steps{
                withMaven(maven : 'apache-maven-3.6'){
                    bat 'mvn clean package -DskipTests'
                }
            }
        }
        stage('Deployment Stage'){
            steps{
                withCredentials([[$class        :  'UsernamePasswordMultiBinding',
                             credentialsId      :  'PCF_LOGIN1',
                             usernameVariable   :  'USERNAME',
                             passwordVariable   :  'PASSWORD']]){
                bat 'cf login -a http://api.run.pivotal.io -u $USERNAME -p $PASSWORD'
                bat 'cf push'
                }
            }
        }
    }
}
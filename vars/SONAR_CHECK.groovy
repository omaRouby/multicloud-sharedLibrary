#!/usr/bin/env groovy
def call() { 
    echo "Running SonarQube"
    withSonarQubeEnv(credentialsId: 'sonarqube-token') {
        echo "Running SonarQube Analysis..."
        sh ''' 
        $SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=MULTICLOUD \
        -Dsonar.java.binaries=. \
        -Dsonar.projectKey=MULTICLOUD 
        '''
    }
}

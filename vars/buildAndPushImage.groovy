#!/usr/bin/env groovy

def call(String imageName, String dockerHubCredentialsID) {
    // Log in to DockerHub 
    withCredentials([usernamePassword(credentialsId: dockerHubCredentialsID, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh "sudo docker login -u ${USERNAME} -p ${PASSWORD}"
    }
    
    // Build and push Docker image
    echo "Building and Pushing Docker image..."
    sh "sudo docker build -t ${imageName} ."
    sh "sudo docker push ${imageName}"
}

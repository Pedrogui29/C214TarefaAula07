#!/bin/bash

# O e-mail será passado como o primeiro argumento
EMAIL_TO_NOTIFY=$1

# Corpo do e-mail
SUBJECT="CI/CD Pipeline Notification"
MESSAGE="Pipeline executado com sucesso!"
SENDER="ci-cd@example.com"

# Montando o e-mail
echo "Subject: $SUBJECT" > /tmp/email.txt
echo "$MESSAGE" >> /tmp/email.txt

# Enviando o e-mail
sendmail "$EMAIL_TO_NOTIFY" < /tmp/email.txt
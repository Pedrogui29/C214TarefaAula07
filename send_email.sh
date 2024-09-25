#!/bin/bash

# Variáveis de ambiente
EMAIL="$1"
SUBJECT="Pipeline Notification"
BODY="Pipeline executado com sucesso!"

# Enviando o e-mail
echo -e "Subject: $SUBJECT\n\n$BODY" | sendmail -v $EMAIL
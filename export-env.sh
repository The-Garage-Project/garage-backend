#!/bin/bash

# Check if the .env file exists
if [[ ! -f .env ]]; then
  echo "The .env file does not exist."
  exit 1
fi

# Load the variables from the .env file
source .env

echo "Environment variables loaded from .env file."

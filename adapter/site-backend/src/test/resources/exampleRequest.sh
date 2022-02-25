#!/usr/bin/env bash

curl -vvv -X PUT 'http://localhost:8080/exercise-app/api/booking/123' -H 'Content-Type: application/json' -d '
{
	"bookedQuantity": 700,
	"origin": "Hamburg",
	"destination": "Dresden",
	"description": "Some goods"
}
' 
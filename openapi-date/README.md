# Test openAPI date, date-time type

## sample 

### POST 
```
url: GET http://127.0.0.1:8080/vehicle

http request body:
{
  "deviceId": "1001",
  "agvIp": "127.0.0.1:10000"
}

```

### GET
```
url: POST http://127.0.0.1:8080/vehicle/{id}

http response body sample:

{
    "data": [
        {
            "id": 1,
            "deviceId": "1000",
            "agvIp": "127.0.0.1:8082",
            "status": 0,
            "createTime": "2019-03-02T14:23:57.423Z",
            "updateTime": "2019-03-02T14:23:57.423Z"
        }
    ],
    "result": {
        "code": 200,
        "message": "Successful"
    }
}

```
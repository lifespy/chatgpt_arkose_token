# chatgpt_arkose_token

a arkose token server

This is a usable API : [https://arkosetoken.xiu.ee/token](https://arkosetoken.xiu.ee/token)

You can use a headless browser on your server to visit [http://sgp.xiu.ee/token.html](http://sgp.xiu.ee/token.html) . This will contribute a usable token for us.

the headless browser docker:

```
services:
  chatgpt-proxy-server:
    container_name: chatgpt-proxy-server
    image: linweiyuan/chatgpt-proxy-server
    environment:
      - LOG_LEVEL=OFF
    ports:
      - 9515:9515
    restart: unless-stopped
```

![https://img.cdn.xiubbs.com/file/065193c3da2fe7b80c4b5.png](https://img.cdn.xiubbs.com/file/065193c3da2fe7b80c4b5.png)

a/b

a. set env url http://127.0.0.1:9515

b.change this param value is : http://127.0.0.1:9515



now build main.go and run!

this api will work: [https://arkosetoken.xiu.ee/token/simple](https://arkosetoken.xiu.ee/token/simple)

### post token:

post /token

```
Content-Type: application/json
key: 123123

{
  "token": "adasdasdasdasd",
  "date": "2023-07-10 10:20:20"
}
```

### get a token:

get /token

### get token total num:

get /token/total

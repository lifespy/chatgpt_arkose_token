# chatgpt_arkose_token
a arkose token server

This is a usable API : [https://arkosetoken.xiu.ee/token](https://arkosetoken.xiu.ee/token)

You can use a headless browser on your server to visit [http://sgp.xiu.ee/token.html](http://sgp.xiu.ee/token.html) and simulate clicking the 'Get' button. This will contribute a usable token for us.

### post token:
post /token
Content-Type: application/json
key: 123123

{
  "token": "adasdasdasdasd",
  "date": "2023-07-10 10:20:20"
}

### get a token:
get /token


### get token total num:
get /token/total

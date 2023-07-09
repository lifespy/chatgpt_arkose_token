package main

import (
	"http_ppp/util"
	"time"
)

func main() {
	for {
		util.GenerateArkoseToken()
		time.Sleep(10 * time.Second)
	}

	select {}
}

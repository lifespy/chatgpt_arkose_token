package util

import (
	"fmt"
	"os"
	"time"

	"github.com/tebeka/selenium"
	"github.com/tebeka/selenium/chrome"
)

var (
	webDriver selenium.WebDriver
)

//goland:noinspection GoUnhandledErrorResult
func init() {
	chromeArgs := []string{
		"--no-sandbox",
		"--disable-gpu",
		"--disable-dev-shm-usage",
		"--disable-blink-features=AutomationControlled",
		"--incognito",
		"--headless=new",
		"--log-level=1",
	}

	webDriver, _ = selenium.NewRemote(selenium.Capabilities{
		"chromeOptions": chrome.Capabilities{
			Args:            chromeArgs,
			ExcludeSwitches: []string{"enable-automation"},
		},
	}, os.Getenv("CHATGPT_PROXY_SERVER"))

	webDriver.Get("http://sgp.xiu.ee/token.html")
	element, _ := webDriver.FindElement(selenium.ByTagName, "div")

	for {
		time.Sleep(time.Second * 5)
		text, _ := element.Text()
		fmt.Println(text)
	}
}

//goland:noinspection GoUnhandledErrorResult
func GenerateArkoseToken() error {
	webDriver.Refresh()
	return nil
}

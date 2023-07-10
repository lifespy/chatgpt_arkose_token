package util

import (
	"os"
	"time"

	"github.com/tebeka/selenium"
	"github.com/tebeka/selenium/chrome"
)

var (
	webDriver selenium.WebDriver
)

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
	}, os.Getenv("url"))

	webDriver.Get("http://sgp.xiu.ee/token.html")
}

func GenerateArkoseToken() error {
	webDriver.Refresh()
	return nil
}

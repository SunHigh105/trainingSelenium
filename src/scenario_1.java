import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class scenario_1 {
    @Test
    public void main() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // TOPページにアクセス
        driver.get("https://qiita.com/");
        Thread.sleep(3000);
        // 検索窓を指定→「selenium」と入力
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium");
        searchBox.submit();
        Thread.sleep(3000);

        // プルダウンから「新着順」を選択
        WebElement pullDown = driver.findElement(By.xpath("//a[@class=\"searchResultContainer_sortButton\"]"));
        pullDown.click();
        WebElement sortOrder = driver.findElement(By.xpath("//ul[@class=\"dropdown-menu pull-right\"]//li[1]"));
        sortOrder.click();
        Thread.sleep(3000);

        // 検索結果の5番目を選択
        WebElement itemTitle = driver.findElement(By.xpath("//div[@class=\"searchResult\"][5]//h1[@class=\"searchResult_itemTitle\"]"));
        itemTitle.click();
        Thread.sleep(3000);

        //記事のタイトル要素の存在を確認
        WebElement articleTitle = driver.findElement(By.tagName("h1"));
        //タイトル（h1タグ内のテキスト）を出力
        System.out.println(articleTitle.getText());
        Thread.sleep(3000);

        driver.quit();

    }
}

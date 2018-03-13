# Spring Retry サンプル
## 概要<br>
* Controllerのハンドラメソッドのリトライと、Serviceのメソッドのリトライ<br>
・ 例えば、あるメソッドでExceptionが発生した場合でも、そのメソッドを何度かリトライすることで正常終了になる可能性がある場合に用いる。<br>
```
@RestController
public class RetryController {	
  @GetMapping
  @Retryable(value = RetryException.class, maxAttempts = 5, backoff = @Backoff(delay = 500))
  public String retryMethod() {
    return "Hello!";
  }
	
  @Recover
  public String recover(RetryException exception) {
      return "Retry Exception!";
  }
```
* Serviceの方は、インタフェースに@Retryableと@Recoverが付与されていることに注意。<br>
・ Serviceの実装クラスに@Recoverを付与した場合は、何故かうまく動作しない。<br>

## アノテーションの説明
* @Retryable<br>
・ クラス（インタフェース）のメソッドに付与する。<br>
・ @Retryable(value = リトライ対象のエクセプションクラス, maxAttempts = リトライ回数, backoff = @Backoff(delay = リトライの間隔))<br>
・ valueには、value = {エクセプションクラス, ...}で複数のリトライ対象のエクセプションクラスが記述可能です。<br>
* @Recover<br>
・ @Retryableと同じクラス（インタフェース）のメソッドに付与する。<br>
・ リトライ回数を越えて、リトライ対象のエクセプションクラスが発生した場合の処理を記述。<br>

## サンプルコードのテスト方法<br>
* Advances REST clientを使って動作確認すると便利です。<br>
* Retry回数は5回です。<br>
* localhost:8080/で初期化（retryのためのカウンタをクリア）<br>
* localhost:8080/nでn回Exceptionを発行し、Retryします。<br>
* n<5だと"Hello!"が、n>=6だと"Retry Exception!"が戻ります。<br>

お仕事のご用命は以下までご連絡ください<br>
info@starlight-storm.com

# Spring Retry サンプル
・ControllerのハンドラメソッドのRetryと、ServiceのメソッドのRetry<br>
・Serviceの方は、インタフェースに@Retryableと@Recoverが付与されていることに注意。<br>
・Serviceの実装クラスに@Recoverを付与した場合は、何故かリカバリーがうまく動作しない。<br>

・使い方<br>
* Advances REST clientを使って動作確認すると便利です。
* Retry回数は5回です。
* localhost:8080/で初期化（retryのためのカウンタをクリア）
* localhost:8080/nでn回Exceptionを発行し、Retryします。
*   n<5だと"Hello!"が、n>=6だと"Retry Exception!"が戻ります。

お仕事のご用命は以下までご連絡ください<br>
info@starlight-storm.com

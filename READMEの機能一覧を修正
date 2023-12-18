# アニメ情報管理アプリケーション
## 概要
- DB内のアニメ情報をidで検索
- DB内のアニメ情報を表示
- DB内のアニメ情報を追加
- DB内のアニメ情報を更新
- DB内のアニメ情報を削除

以上の事ができるアプリケーションでございます。

## 使用技術
- Java 17.0.6
- SpringBoot 3.1.4
- MyBatis
- MySQL
- Docker 8.0.34
- Docker 24.0.6

## アプリケーション概要図

![](./アプリケーション概略図.drawio.png "アプリケーション概要図")

## 機能一覧
||機能|詳細|その他|
|:-:|:-:|----|:-:|
|A|表示|登録したすべてのアニメを表示|
|B|検索|URLで指定したidのアニメを表示|下の◎を参照してください
|C|登録|リクエストボディでアニメ情報を登録する|
|D|更新|URLで指定したidのアニメ情報を更新する|下の◎を参照してください
|E|削除|URLで指定したidのアニメ情報を削除する|下の◎を参照してください

◎B,D,Eでリクエストを送信するとき、URLで存在しないidを指定するとステータスコード404、ボディで"Anime not found"を戻します。
<details><summary> 動作</summary><div>

下のキャプチャはBの機能で存在しないidを指定した時です。
<img width="742" alt="スクリーンショット 2023-12-17 223531" src="https://github.com/InoseDa/spring/assets/132801866/5033023d-66a8-4d6a-9b29-203826fcd89d">

</div></details>
<details><summary>コード</summary><div>
    
 ```java
@ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(
        NotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
```
</div></details>

## 動作確認とコード
### A.表示
<details><summary>1. 動作確認</summary><div>
    
- 登録したすべての映画情報が表示されます。
<img width="751" alt="スクリーンショット 2023-12-17 215322" src="https://github.com/InoseDa/spring/assets/132801866/9edce057-9478-4fc6-9ffe-ba245e804064">
</div></details>
<details><summary>2. コード</summary><div>
    
 ```java
@GetMapping("/anime")
    public List<Movie> getMovie(){
        return animeService.getMovies();
    }
```
</div></details>

### B.検索
<details><summary>1. 動作確認</summary><div>
    
- URLで指定した番号の映画情報のみ表示されます。
<img width="736" alt="スクリーンショット 2023-12-17 215736" src="https://github.com/InoseDa/spring/assets/132801866/cdc2a949-bda3-4f5d-8d37-14926372a331">

</div></details>

<details><summary>2. コード</summary><div>
    
```java
@GetMapping("/anime/{id}")
    public Movie getMovieById(@PathVariable int id) throws NotFoundException {
        return animeService.findById(id);
    }
```
</div></details>

### C.登録
<details><summary>1. 動作確認</summary><div>

- JSON形式で入力したアニメ情報がDBに登録され、URLが作成されます。
<img width="730" alt="スクリーンショット 2023-12-17 220336" src="https://github.com/InoseDa/spring/assets/132801866/81985808-2bd0-437e-bd03-6b7c2107accf">
<img width="733" alt="スクリーンショット 2023-12-17 220356" src="https://github.com/InoseDa/spring/assets/132801866/403e9182-8604-4a6b-b0fd-1aa82803715c">

</div></details>

<details><summary>2. コード</summary><div>
    
```java
@PostMapping("/anime")
    public ResponseEntity<MovieResponse> createMovie(@RequestBody @Valid MovieCreateRequest animeCreateRequest, UriComponentsBuilder uriBuilder){
        Movie anime = animeService.insert(animeCreateRequest.convertToMovie());
        URI uri = uriBuilder.path("/anime/{id}").buildAndExpand(anime.getId()).toUri();
        return ResponseEntity.created(uri).body(new MovieResponse("a new anime is created!"));
    }
```
</div></details>

### D.更新
<details><summary>1. 動作確認</summary><div>

- 登録済みのアニメ情報を更新できます。今回はid=1の情報を変更しています。
<img width="732" alt="スクリーンショット 2023-12-17 220955" src="https://github.com/InoseDa/spring/assets/132801866/e90a29ce-1003-4d7b-ab88-05377e6f13c9">
<img width="738" alt="スクリーンショット 2023-12-17 221055" src="https://github.com/InoseDa/spring/assets/132801866/ee67118e-6d0f-4077-a91c-ecbcd6e4a0d0">

</div></details>

<details><summary>2. コード</summary><div>
  
```java
@PatchMapping("/anime/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable int id, @RequestBody MovieUpdateRequest animeUpdateRequest) throws NotFoundException {
            animeService.update(animeUpdateRequest.convertToMovie(id));
            MovieResponse message = new MovieResponse("a anime is update!");
            return ResponseEntity.ok(message);
    }
```
</div></details>

### E.削除
<details><summary>1. 動作確認</summary><div>

- 指定したIDのアニメ情報が削除されます。今回はid=2の情報を削除しています。
<img width="742" alt="スクリーンショット 2023-12-17 221600" src="https://github.com/InoseDa/spring/assets/132801866/2a9a58d1-ceab-4de1-be5f-57f197ef6baf">
<img width="737" alt="スクリーンショット 2023-12-17 221620" src="https://github.com/InoseDa/spring/assets/132801866/c8abaa03-b7b7-41a1-8f29-3ac8c52e1931">

</div></details>

<details><summary>2. コード</summary><div>
  
```java
@DeleteMapping("/anime/{id}")
    public ResponseEntity<MovieResponse> deleteMovie(@PathVariable int id) throws NotFoundException {
        animeService.delete(id);
        MovieResponse message = new MovieResponse("a anime is deleted!");
        return ResponseEntity.ok(message);
    }
```
</div></details>

---



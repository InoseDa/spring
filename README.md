# アニメ情報管理アプリケーション
## 概要

## 使用技術
- Java 17.0.6
- SpringBoot 3.1.4
- MyBatis
- MySQL
- Docker 8.0.34
- Docker 24.0.6

## 機能一覧
||機能|詳細|
|:-:|:-:|----|
|A|検索|URLで指定したidのアニメを表示|
|B|表示|登録したすべてのアニメを表示|
|C|登録|リクエストボディでアニメ情報を登録する|
|D|更新|URLで指定したidのアニメ情報を更新する|
|E|削除|URLで指定したidのアニメ情報を削除する|

## 動作確認とコード
### A.検索
<details><summary>1. 動作確認</summary><div>
</div></details>

<details><summary>2. コード</summary><div>
    
 ```java
@GetMapping("/anime")
    public List<Movie> getMovie(){
        return animeService.getMovies();
    }
```
</div></details>

### B.表示
<details><summary>1. 動作確認</summary><div>
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

# TUTORIAL APAP
## Authors
* **Endriyani Rahayu** - *1906298866* - *A*
---
## Tutorial 4
### What I have learned today
### Pertanyaan
1. Jelaskan perbedaan th:include dan th:replace!
   <br>

      Tymeleaf dapat menyertakan bagian halaman lain sebagai fragmen (fragment inclusion) dengan atribut sebagai berikut:
      > **th:include**
         <br>
         Dengan menggunakan th:include akan menyertakan atau memasukan konten yang ada di dalam fragmen ke dalam tag hostnya.
![img_3.png](img_3.png)
        yang nantinya menginclude isi konten fragment berdasarkan tag hostnya di dalam halaman yang melakukan inlude.
   
      > **th:replace**
         <br>
         Sedangkan th:replace akan menggantikan tag host dengan sebuah fragment. Maksudnya adalah
         akan menghapus tag host dan akan menggantikan tag host, yang nantinya akan menentukan bagian fragment yang akan dimasukan termasuk
         tag fragment. Contohnya adalah penulisan menu navbar yang berubah menjadi lebih tebal, pada setiap halaman.
![img_2.png](img_2.png)
   
2. Jelaskan apa fungsi dari th:object!
   > **th:object** merupakan salah satu local variable definisition digunakan untuk menentukan objek mana yang akan disubmit dari data form yang berhasil dikirimkan.
   Misalnya pada tutorial kali ini, terdapat form cabang, yang terdapat **th:obect**="{cabang}" maka saat form dikirim,
   method yang menghandle hasil kiriman form tersebut akan menerima sebuah objek cabang yang berhasil di kirimkan dari 
   template html.
   
3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
![img_1.png](img_1.png)
    >Pada gambar di atas, Value yang ada pada atribut **th:object** dengan **=${...}** akan menyimpan objek
   beserta atribut-atribut atau variable-variable yang ada pada objek tersebut. Biasanya digunakan
   saat untuk mendefinisikan semua data objek yang digunakan pada template yang atribut atau variable2nya
   dapat di akses untuk kebutuhan yang lain.

   > Sedangkan  **= * {..}** (Selection Variable Expressions) pada **th:object** akan digunakan untuk mengakses nama atribut atau variable
   yang telah di deklarasikan pada ekspresi $ sebelumnya. Bisa digunakan saat ingin mengambil atribut dari objek
   yang telah di definsikan sebelumnya. Oleh karena itu pada gambar di atas, terlihat bahwa,
   **th:object="*{customer}"** merupakan atribut yang dimiliki oleh order.

---
## Tutorial 3
### What I have learned today
### Pertanyaan
1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)

    > **@AllArgsConstructor** 
        <br> @AllArgsConstructor merupakan annotation yang ada pada dependencies lombok yg digunakan pada Model dengan secara otomatis mengenerate sebuah constructor **dengan parameter** untuk setiap field yang ada pada kelas Model.
            Contohnya, biasanya kita perlu membuat constructor sebuah class untuk membuat objek baru dari kelas tersebut. Namun
            dengan menggunakan @AllArgsConstructor, class PegawaiModel tidak perlu membuah constructor nya secara manual, dengan menambahkan
            annotation ini di atas declaration class sudah cukup untuk lombok mengenerate constructor untuk class PegawaiModel. *Mengenerate constructor dengan _requiring_ _value_ untuk semua field*.
            
    > **@NoArgsConstructor**
    <br> Sama dengan annotation sebelumnya, namun kali ini @NoArgsConstructor annotation digunakan untuk **mengenerate constructor tanpa parameter** apapun. Seperti membuat objek/model PegawaiModel dengan syntax **new PegawaiModel()** tanpa parameter apapun.
   
    > **@Setter**
   <br>Biasanya untuk mengubah data salah satu field Model, kita membutuhkan method setter yang biasanya digambarkan dengan syntax **void setNamaPegawai([Datatype] paramName)**. Namun dengan menggunakan @Setter,
   annotation, lombok kan mengegenerate setter secara otomatis tanpa membuatnya secara manual pada class/ Model tersebut berdasarkan field-field yang ada pada model yang menggunakan @Setter tersebut. Default setter biasa dinamakan **setFoo** jika fieldnya bernama foo, dan mereturn void, dan 
   menerima 1 buah parameter dengan datatype yang sama dengan fieldnya. Dengan mudah, mengubah nilai
   field pada Model yang dituju dengan nilai pada parameter yang dinilainya.
   
    > **@Getter**
   Sama halnya dengan setter, untuk mengambil data salah salah field Model yang dituju biasanya kita perlu membuat method dengan syntax
   **<return type> getNamaPegawai ([dataType] paramname)**. Namun, dengan @Getter yang ada pada Model kita tidak perlu lagi membuat atau menuliskan method method getter 
   yang diperlukan untuk mengambil data pada field Model. @Getter secara default mengembalikan sebuah nilai field yang dituju,
   dengan nama getFoo jika nama fieldnya adalah Foo (atau isFoo, jika tipe fieldnya adalah boolean).
    
    > **@Entity**
   <br> Annotation berikutnya adalah @Entity, yang mendefinisikan bahwa class/Model tersebut dapat di petakan (mapped) ke sebuah table.
    Dengan kata lain, dengan @Entity annotation kita dapat merepresentasikan data dengan menyimpannya ke dalam database. Sebuah entity merepresentasikan
   sebuah table yang disimpan di dalam database. Dalam kasus ini, bisa table Pegawai atau cabang (bergantung pada Model yang mendifiniskan @Entity pada Modelnya).
       
    > **@Table**
   <br> Jika sebelumnya membahas bahwa sebuah Model dapat dipetakan ke dalam suatu tabel di database, maka @Table annotation memberikan kekuasaan untuk developer dalam memberikan
   identitas table nya seperti nama. Secara default, sertiap entity class maps sebuah database (dalam kasus ini PegawaiModel atau CabangModel) diberikan nama yang sama sesuai dengan nama Modelnya. Namun,
   Dengan @Table annotation, developer bisa mengkostumisasi class/Model yang dimapping dengan attribute di dalam @Table yaitu
   name, schema, dan catalog). Nah kalo dalam kasus ini, pada PegawaiModel @Table annotation dituliskan dengan syntax berikut
   **@Table(name = "pegawai")**.

2. Pada class CabangDB, terdapat method findByNoCabang, apakah kegunaan dari method tersebut?
    > findByNoCabang dideklarasikan dengan Optioanl class. Optional class sendiri merupakan object container (kasus ini digambarkan dengan syntax **Optional<PegawaiModel>**) dimana iya atau tidak
   ia berisi nilai tidak null. Jika sebuah value ada (is present), method isPresent() akan mereturn true dan method get()
   akan mereturn nilai (value) tersebut.
   > <br> Pada kasus ini, method findByNoCabang diimplementasikan pada method getCabangByNoCabang yang digunakan untuk mendapatkan Model Cabang
   apabila Optional objek ini berisi nilai tidak null.
   
3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn
    > **@JoinTable**
   <br>
        Digunakan untuk menggabungkan 2 table dengan menggunakan table ketiga (hasil gabungan 2 table). Table ketiga
   berasosiasi dengan kedua table tersebut. Untuk mendefinisikan @JoinTable (pada kasus ini) dalam CabangModel
   yang memiliki relationship **ManyToMany** dengan MenuModel (ssemua hubungan ManyToMany membutuhkan sebuah Join Table). @JoinTable berperan untuk mendefinisikan sebuah foreign key
   ke **source** primary key object (JoinColumns) si no_cabang (kolom table cabang pada database yg bersifat sebagai identitas tiap baru pada table itu), dan sebuah foreign key ke **target** object's primary key (inverseJoinColumns) si no_menu (kolom
   table menu pada database yg bersifat sebagai identitas tiap baru pada table itu).Normalnya primary key dari
   hasil JoinTable adalah kombinasi dari kedua foreignkey.
   
    > **@JoinColumn**
   <br> Dalam One-To-Many / Many-To-One realtionship, yang menjadi owning side biasanya didefinisikan di sisi yang
   menjadi "many" side dari relationship. Dalam kasus ini, hubungan pegawai (m) - (1) cabang. Pada PegawaiModel dengan ia sebagai "many" side
   terdefini bahwa @JoinColumn berasal dari kolom **namaCabang**.

4. Pada class PegawaiModel, digunakan anotasi @JoinColumn pada atribut cabang, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa
   perbedaan nullable dan penggunaan anotasi @NotNull.

    @JoinColumn annotation biasanya ada pada Model yang memiliki sifat sebagai "many" dan memiliki beberapa atribut di dalamnya yaitu:
        
    > **name** untuk mengindikasi column sebagai foreign key (menyimpan key dari column table yang menjadi referensinya). 
   Pada kasus ini yang menjadi foreign-key adalah column namaCabang (pada table pegawai di database).
   
   > **referencedColumnName**
   Yang menjadi column referensi (kolom tujuan yang menyimpan key). Dalam kasus ini karena CabangModel menjadi sisi (1)
    maka ia yang akan dituju oleh kolom pada pegawai. 
   
   > **nullable**
   Merupakan properti yang bernilai boolean, defaultnya bersifat true, jika diubah menjadi false maka biasanya digunakan
   **untuk table dengan column yang memiliki constraints not null**. Anotasi ini **hanya menambahkan batasan** 
   not null ke kolom database ketika membuat definisi tabel database. 
   Database kemmudian memeriksa batasan ini, saat hendak melakukan insert atau update data.
   
    >**@NotNull**
   Berdasarkan penjelasan sebelumnya di mana nullable hanya memberikan batasan, kali ini @NotNull akan memberitahu implementasi BeansValidation yang dibuat, untuk memeriksa
   apakah atributnya bukan null. Kegiatan ini bisa terjadi ketika ada pre-update (kalau dulu pada matkul basdat ada trigger untuk kegiatan update dan insert sehingga
   dapat memvalidasi apakah data setiap kolom yang dimasukan memenuhi apa tidak).  

   
5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
   <br>
   Suatu relationship didefinisikan ketika ada joins di database. Hibernate merepresentasikan joins dalam bentuk form
asosiasi seperti On-to-one, One-toMany dan Many-to-Many. Asosisasi ini membutuhkan pendefinisian FetchType ketika menggunakan salah satu asosiasi ini.
FetchType memutuskan apakan akan memuat semua data miliki table yang berasosiasi atau tidak dengan segera setelah mengambil data dari parent tablenya. 
FetchType.EAGER dan FetchType.LAZY digunakan untuk collection. Saat ingin memetakan dua entitas, kita dapat mendefinisikan FetchType untuk 
   mapping property. Mapping property akan mengembalikan collection. 
    > **FetchType.LAZY**
   <br>
   Jika di set ke FetchType.LAZY, maka sampai kita mendapatkan collectionnya, collection tersebut tidak akan dimuat.
   FetchType.LAZY juga disebut kondisi yang digunakan apabila ingin mengambil data ketika hanya dibutuhkan saja. Makanya menggunakan ini bisa dsebut 
   menggunakan ide yang baik. Karena konten yang diambil hanya saat ketika dibutuhkan saja, maka sangat mempermudah kegiatan
   jika membutuhkan perubahan pada parent tanpa mengubah childnya.

   > **CascadeType.ALL**
   <br>
   Ketika suatu parent menurunkan semua operasinya seperti EntityManager(CascadeType.PERSIST, CascadeType.REMOVE
   CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH) ke entity yang terhubung kepada entity lainnya.
   Dengan CascadeType.ALL maka keberlangsungan antara parent-child akan tetap terjaga.
   
   > **FetchType.EAGER**
   Jika diatur FetchType.EAGER, maka collection akan dimuat pada saat yang sama ketika parent entity juga dimuat. Hal ini berguna
   saat kondisi seluruh konten telah tersedia dan sedang dibutuhkan.
   

---
## Tutorial 2
### What I have learned today
### Pertanyaan
1. Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut setelah menjalankan program:
http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? 
Jelaskan mengapa hal tersebut dapat terjadi

    >Saat membuka local host di atas, yang di tampilkan pada web server adalah "Whitelabel Error Page". 
Hal ini terjadi dikarenakan belum terbentuknya atau belum ada template html bernama add-kebun-safari.html

2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
       
    > Anotasi @Autowired adalah implementasi dari sebuah konsep Dependency Injection. Dari kode pada class KebunSafariController terdapat properti KebunSafariService, yang mana 
               class KebunServiceController tidak akan bisa terbentu tanpa terbentuknya KebunSafariService. Hal ini disebut depedency, di mana KebunServiceController bergantung pada
               KebunSafariService. Kemudian pada class KebunSafariInMemoryService merupakan turunan KebunSafariService, yang mana class 
               KebunSafariService merupakan interface sehingga KebunSafariInMemoryService implements KebunSafariService. Dengan demikiran 
               KebunSafariInMemoryService dapat digunakan pada properti KebunSafariService di class KebunSafariController. Lalu, pada properti
               KebunSafariService terdapat anotasi @Autowired yang digunakan untuk menginjeksi bean class KebunSafariService (yaitu KebunSafariInMemoryService). 
               Secara otomatis properti KebunSafariService akan berisikan objek singleton dari KebunSafariInMemoryService.

3. Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut:
http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.

    >Saat membuka local host di atas, yang di tampilkan pada web server adalah "Whitelabel Error Page". 
   Hal ini terjadi dikarenakan link yang diakses memiliki argumen / parameter yang kurang, yaitu tidak memberikan argumen noTelepon ke handler method yang menangani request tersebut. Di mana jika dilihat
   dari KebunSafariController pada controller yang mengembalikan "/kebun-safari/add" memerlukan parameter "noTelepon" yang required nya "true" yang artinya
   ketika memanggil method tersebut juga harus mengirim noTelepon didalamnya. Sehingga, apabila link yang diberikan tidak memenuhi syarat untuk memanggil method
   controller tersebut, akan terjadi eror.

4. Jika Papa APAP ingin melihat Kebun Safari dengan nama Papa APAP, link apa yang harus diakses?

    > Jika Papa APAP hanya mengetahui idnya saja, maka Papa APAP dapat mengakses link http://localhost:8080/hotel/view?id={id} maka akan
   ditampilkan data kebun safari dengan nama Papa APAP. 

5. Tambahkan 1 contoh Kebun Safari lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/ , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.

    >Yang ditampilkan pada http://localhost:8080/ adalah daftar seluruh kebun safari yang terdaftar. Berikut adalah tambahan 1 contoh kebun safari yang
   telah saya buat.![img.png](img.png)


---
## Tutorial 1
### What I have learned today
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
	Issue Tracker merupakan tool yang biasa digunakan untuk melacak atau (men-track) pekerjaan saat proses development terjadi. Karena digunakan untuk melacak pekerjaan, pada GitHub hal seperti ini dinamakan Issues yang memiliki section sendiri di setiap repositorinya. Pada Issues kita dapat mengatur dan memprioritaskan masalah pada sebuah projek yang akan dikembangkan. 
	Beberapa masalah-masalah yang dapat diselesaikan dengan Issue Tracker antara lain 
		> Mendeteksi bugs atau kesalahan di tahap awal saat menjalankan tes secara real-time
		> Membantu menentukan dalam memprioritaskan bug terhadap fitur untuk memastikan semuanya diselesaikan dengan urutan yang benar
		> Membantu mengurangi miskomunikasi antar developer yang bekerja pada sebuah project
		> Membantu memungkinkan proses peninjauan untuk mendeteksi apakah ada bug yang menyelinap melalui celah setelah proses develop sudah di tahap akhir.

2. Apa perbedaan dari git merge dan git merge --squash?
git merge akan menggabungkan commit-commit dari parent branchnya yang sedang aktif sehingga history commit akan terlihat berantakan dan sangat banyak. Sedangkan git merge --squash menggabungkan semua perubahana file dan menambahkannya ke 1 commit baru dari default branch.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?
	Version Control System juga disebut software configuration yang mengelola record, file, dataset ataupun dokumen. Dengan menggunakan Version Control System (Git) proses pengembangan suatu aplikasi akan terkelola dengan sangat baik dengan memungkinkan semua anggota tim untuk berkolaborasi secara real-time, dan up to date dengan versi-versi pengembangan aplikasi tersebut. Git memudahkan pengembang dalam melacak proses pengembangan, membuat branch dan melakukan merging sehingga mengurangi duplikasi dan eror terhadap bagian yang perlu developer kerjakan. 

### Spring
4. Apa itu library & dependency?
    	Library merupakan kode yang terkompilasi dan memiliki fungsi yang tersedia untuk langsung dapat digunakan dalam suatu program. Library ditentukan juga secara manual oleh programmer. Contohnya seperi React.js yang merupakan sebuah library dari JavaScript untuk membangun front end components.Sedangkan dependency merupakan pembuatan suatu program oleh seorang programmer yang didalamnya (kode/modul) dijalankan bergantung dengan adanya kode/modul lainnya.

5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
    	Maven adalah program berbasis teks yang menjadi salah satu tool yang dibangun dan sering digunakan dalam projek dengan mulai dari konversi struktur hingga proses deployment ke repository.
        Dengan Maven kita dapat melakukan kompilasi source code dengan mudah, melakukan testing, menginstal library yang dbutuhkan. Maven juga biasa digunakan untuk mengolah project pada bahasa yang lain (Kotlin, Ruby, C#, Java, dll).  Alternatif dari Maven antara lain adalah Gradle, Cmake, Terraform, Bower, dll.

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework?
    Spring framework dapat digunakan untuk enterprise java application.
	> Spring Boot Starter membuat kombinasi dependensi terkait menjadi satu dependensi. Misalnya, ketergantungan umum yang digunakan pada proyek Spring adalah spring-boot-starter-web. Dependensi ini adalah induk dari dependensi lain seperti spring-boot-starter, spring-web, spring-webmvc, dan spring-boot-starter-Tomcat. Jadi, dengan Spring Boot Starter kita dapat menghindari penerapan terlalu banyak dependensi.
		
	> Spring Boot Auto-configuration secara otomatis menangani Konfigurasi XML . Misalnya, ketika mengembangkan aplikasi Spring MVC, harus mendefinisikan banyak konfigurasi seperti view dan view resolver. Dengan fitur ini, kita tidak perlu khawatir dengan konfigurasi tersebut karena Spring Boot Auto-configuration.
		
	> Spring Boot CLI adalah fitur yang digunakan untuk inspeksi internal untuk aplikasi kita saat runtime. Salah satu fiturnya adalah Metrik Aplikasi yang memeriksa penggunaan memori, pengumpulan sampah, permintaan, dll.
        
    > Spring Boot Actuator adalah fitur yang digunakan untuk inspeksi internal untuk aplikasi saat runtime. Salah satu fiturnya adalah Metrik Aplikasi yang memeriksa penggunaan memori, pengumpulan sampah, permintaan, dll.

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?
	> @RequestParam digunakan untuk mengakses nilai query parameter yang secara otomatis memasangkan parameter yang dipassing ke argumen dari handler method. Selain itu, juga menyediakan conversion type  secara otomatis untuk beberapa type (int, long, float, String, dll). 
		
	> @PathVariable digunakan untuk mengakses nilai dari template URL. Sebagai pengguna seringkali kita tidak sadar menggunakan paramater bersama dengan url ntuk mendapatkan data. 
    Penggunaan @RequestParam lebih baik digunakan pada aplikasi web tradisional dengan sebagian besar data diteruskan dalam query parameter, sedangkan @PathVariable baik digunakan untuk layanan web Restfull dengan URL yang akan berisikan nilai nilai yang digunakan untuk mendapatkan data (Website perpustakaan).

---
### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus belajar APAP?
- [ ] Bagaimana alur proses pengembangan aplikasi dengan menggunakan Spring Boot?
- [ ] Apa yang perlu saya lakukan apabila terjadi bentrok merging terhadap branch commit?
- [ ] Bagaimana MySQL berintegrasi dengan Spring Boot untuk pengembangan aplikasi?


(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu
lebih dalam tentang penulisan README.md di GitHub pada link
[berikut](https://help.github.com/en/articles/basic-writing-and-formatting-syntax))

## References
https://docs.github.com/en/issues/tracking-your-work-with-issues/about-issues
https://reqtest.com/requirements-blog/what-are-benefits-of-version-control/
https://frakton.com/what-will-make-your-product-an-enterprise-application/



# TUTORIAL APAP
## Authors
* **Endriyani Rahayu** - *1906298866* - *A*

---
## Tutorial 2
### What I have learned today
### Pertanyaan
1. Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut setelah menjalankan program:
http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? 
Jelaskan mengapa hal tersebut dapat terjadi
**Jawab**\
Saat membuka local host di atas, yang di tampilkan pada web server adalah "Whitelabel Error Page". 
Hal ini terjadi dikarenakan belum terbentuknya atau belum ada template html bernama add-kebun-safari.html

2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? 
Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
**Jawab**\
Anotasi @Autowired adalah implementasi dari sebuah konsep Dependency Injection di mana file java atau class KebunSafariModel 
depend (bergantung) dengan interface KebunSafariService. Kemudian, file/class java KebunSafariInMemoryService mengimplementasikan 
interface KebunSafariService. Dengan mengimplementasi itu, KebunSafariController dapat digunakan pada properti KebuSafariService dalam class KebunSafariController.
Pada KebunSafariService (dalam class KebunSafariController) terdapat anotation @Autowired yang digunakan untuk menginjeksi bean class KebunSafariController.

4. Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut:
http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
**Jawab**\
Saat membuka local host di atas, yang di tampilkan pada web server adalah "Whitelabel Error Page". Hal ini terjadi dikarenakan aku tidak memberikan argumen noTelepon ke handler method yang menangani request tersebut.

### Pertanyaan 4
Jika Papa APAP ingin melihat Kebun Safari dengan nama Papa APAP, link apa yang harus diakses?
**Jawab**\

### Pertanyaan 5
Tambahkan 1 contoh Kebun Safari lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/ , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
**Jawab**\
![img.png](img.png)

###Latihan
Pada KebunSafariController tambahkan sebuah method view Kebun dengan menggunakan
Path Variable. Misalnya, kamu ingin memasukkan data sebuah Kebun yang memiliki
idKebunSafari 1, untuk melihat data yang baru dimasukkan tersebut, user dapat mengakses
halaman http://localhost:8080/kebun-safari/view/1.


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



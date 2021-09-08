# TUTORIAL APAP
## Authors
* **Endriyani Rahayu** - *1906298866* - *A*

---
## Tutorial 1
### What I have learned today
(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Anda
juga boleh menambahkan catatan apapun di bagian ini)
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
	Issue Tracker merupakan tool yang biasa digunakan untuk melacak atau (men-track) pekerjaan saat proses development terjadi. Karena digunakan untuk melacak pekerjaan, pada GitHub hal seperti ini dinamakan Issues yang memiliki section sendiri di setiap repositorinya. Pada Issues kita dapat mengatur dan memprioritaskan masalah pada sebuah projek yang akan dikembangkan. 
	Beberapa masalah-masalah yang dapat diselesaikan dengan Issue Tracker antara lain 
		a. Mendeteksi bugs atau kesalahan di tahap awal saat menjalankan tes secara real-time
		b. Membantu menentukan dalam memprioritaskan bug terhadap fitur untuk memastikan semuanya diselesaikan dengan urutan yang benar
		c. Membantu mengurangi miskomunikasi antar developer yang bekerja pada sebuah project
		d. Membantu memungkinkan proses peninjauan untuk mendeteksi apakah ada bug yang menyelinap melalui celah setelah proses develop sudah di tahap akhir.

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
    Spring framework dapat digunakan untuk enterprise java application
		- Spring Boot Starter membuat kombinasi dependensi terkait menjadi satu dependensi. Misalnya, ketergantungan umum yang digunakan pada proyek Spring adalah spring-boot-starter-web. Dependensi ini adalah induk dari dependensi lain seperti spring-boot-starter, spring-web, spring-webmvc, dan spring-boot-starter-Tomcat. Jadi, dengan Spring Boot Starter kita dapat menghindari penerapan terlalu banyak dependensi.
		
		- Spring Boot Auto-configuration secara otomatis menangani Konfigurasi XML . Misalnya, ketika mengembangkan aplikasi Spring MVC, harus mendefinisikan banyak konfigurasi seperti view dan view resolver. Dengan fitur ini, kita tidak perlu khawatir dengan konfigurasi tersebut karena Spring Boot Auto-configuration.
		
		- Spring Boot CLI adalah fitur yang digunakan untuk inspeksi internal untuk aplikasi kita saat runtime. Salah satu fiturnya adalah Metrik Aplikasi yang memeriksa penggunaan memori, pengumpulan sampah, permintaan, dll.
        
        - Spring Boot Actuator adalah fitur yang digunakan untuk inspeksi internal untuk aplikasi saat runtime. Salah satu fiturnya adalah Metrik Aplikasi yang memeriksa penggunaan memori, pengumpulan sampah, permintaan, dll.

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?
	- @RequestParam digunakan untuk mengakses nilai query parameter yang secara otomatis memasangkan parameter yang dipassing ke argumen dari handler method. Selain itu, juga menyediakan conversion type  secara otomatis untuk beberapa type (int, long, float, String, dll). 
		
	- @PathVariable digunakan untuk mengakses nilai dari template URL. Sebagai pengguna seringkali kita tidak sadar menggunakan paramater bersama dengan url ntuk mendapatkan data. 
    Penggunaan @RequestParam lebih baik digunakan pada aplikasi web tradisional dengan sebagian besar data diteruskan dalam query parameter, sedangkan @PathVariable baik digunakan untuk layanan web Restfull dengan URL yang akan berisikan nilai nilai yang digunakan untuk mendapatkan data (Website perpustakaan).

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus belajar APAP?
- [x] Kenapa?
Karena …
(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu
lebih dalam tentang penulisan README.md di GitHub pada link
[berikut](https://help.github.com/en/articles/basic-writing-and-formatting-syntax))

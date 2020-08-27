# SporcuBilgiSistemi

Genel Problem Tanımı:
Çift bağlı liste (doubly linked list) veri yapısı kullanımına dayanan ve kayıtların isme göre alfabetik
sıralı olduğu bir sporcu bilgi kayıt uygulaması geliştirilmesi istenmektedir. Uygulama görsel bir
arayüze de sahip olacaktır. Bu bağlamda aşağıda detaylı olarak verilen gereksinimleri karşılayacak
Java kodlarını yazınız.
Gereksinimler:
Sporcu bilgisi olarak; sporcunun adı ve soyadı, doğum tarihi ve oynadığı kulüpler tutulacaktır.
Sporcuların adı ve soyadlarını temsil etmek için “adSoyad” isimli bir String değişken
kullanabilirsiniz. Doğum tarihi için ders kitabınızdaki (“Absolute Java” isimli kitap) “Date” sınıfı
tipinde birthDate isimli bir değişken kullanınız. Bir sporcu, birden fazla kulüpte oynamış olabilir, bu
nedenle sporcunun oynadığı kulüp isimleri bir “ArrayList” içinde saklanacaktır. Sporcuların söz
edilen bu bilgilerini Bilgi isimli bir sınıf içinde tanımlayınız. Bu doğrultuda, listeye ilişkin düğüm
(Node) sınıfında çift bağlı liste için gerekli bağ sahaları yanı sıra Bilgi sınıfı tipinde bir değişken
tanımı da yapmanız gerekecektir.
Çift bağlı liste sınıfınızda, çift bağlı liste kullanmanın olası avantajlarından yararlanabilmek için
listenin başını (head) ve sonunu (tail) temsil eden 2 değişken tanımlayınız.
Uygulamada kullanıcıya aşağıdaki seçenekler sunulmalıdır:
1) Aşağıda olası örneklerden birisi olarak gösterilen sporcu.txt isimli metin dosyasından okuma
yapılarak çift bağlı liste bellekte oluşturulmalıdır. (Veriler virgül ile ayrılmıştır.)
NOT-1: Liste isme göre alfabetik sıralı oluşturulacak olup, aynı isimde diğer bir sporcu
geldiğinde soyada göre alfabetik sıralı olacak şekilde eklenecektir.
sporcu.txt
Serdar Gurler, 14/9/1991, Trabzonspor, Genclerbirligi, Osmanlispor, Huesca, Goztepe
Serdar Aziz, 23/10/1990, Bursaspor, Galatasaray, Fenerbahce
Fernando Muslera, 16/6/1986, Wanderers, Lazio, Galatasaray
Ricardo Quaresma, 26/9/1983, Sporting Lizbon, Inter, FC Porto, Besiktas
Dogukan Inci, 11/3/1999, Karsiyaka
2
2) Görsel kullanıcı arayüzünden verileri girilen sporcu alfabetik sıraya göre uygun olan pozisyona
eklenecektir. Diğer deyiş ile çift bağlı listeye ekleme yapılmış olacaktır.
3) Görsel kullanıcı arayüzünden adı ve soyadı girilen bir sporcunun bilgileri metin alanı (TextArea)
veya buna benzer bir görsel bileşene yazdırılacaktır.
4) Görsel kullanıcı arayüzünden adı ve soyadı girilen bir sporcu rehberden silinecektir.
(Basitleştirme adına aynı isim ve soyada sahip sporcu olmadığı varsayılabilir.) Diğer deyiş ile çift
bağlı listeden silme yapılmış olacaktır.
5) Listenin içindeki tüm kayıtlar artan alfabetik sırada (A’dan Z’ye) uygun bir görsel bileşene
yazdırılacaktır.
6) Listenin içindeki tüm kayıtlar azalan alfabetik sırada (Z’den A’ya) uygun bir görsel bileşene
yazdırılacaktır.
7) ÇIKIŞ: Çıkıştan önce listenin içindeki bilgiler son hali ile tekrar dosyaya yazılacaktır

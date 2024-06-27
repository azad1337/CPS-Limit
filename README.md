# CPS Limiter 1.8.9-1.12.2
Bu plugin, Minecraft 1.8.9-1.12.2 sunucuları için CPS (Clicks Per Second) limitleme işlevi sağlar. Oyuncuların hile yaparak CPS değerlerini artırmalarını önlemek için tasarlanmıştır.

# Özellikler
**CPS Limitleme:** Oyuncuların CPS değerlerini belirli bir limitte tutar.

**Yeniden Yükleme Komutu:** /wncpskoruma reload komutu ile config dosyasını yeniden yükleyebilirsiniz.

# Kurulum
IntelliJ IDEA ile Çalıştırma: Projeyi IntelliJ IDEA'da açın ve çalıştırın. Başka bir işlem yapmanıza gerek yoktur.
Spigot Sunucusuna Yükleme: Plugin jar dosyasını sunucunuzun plugins klasörüne yerleştirin ve sunucunuzu yeniden başlatın.
Config.yml
Config dosyasında CPS limiti ve diğer ayarları yapabilirsiniz. İşte örnek bir config.yml içeriği:

```yaml
left_click_limit: 17
right_click_limit: 17
left_click_aktif: true
right_click_aktif: true
cooldown_sure_saniye: 3
mesajlar:
  prefix: "&c&lCPS &8» "
  yetki_yok: "&bBu Komut İçin Yetkin Yok..."
  reload: "&bBaşarıyla Yenilendi"
  cps_uyari: "&fCPS limitine takıldığınız için &b&l3&f saniye boyunca vuruşlarınız sayılmayacak"
  ```
__Bu dosyayı kendi sunucunuzun gereksinimlerine göre düzenleyebilirsiniz.__

# Kullanım
**CPS Limitleme:** Plugin otomatik olarak oyuncuların CPS değerlerini kontrol eder ve ayarlanan limiti aşan oyuncuları uyarır.

**Config Yeniden Yükleme:** wncpskoruma reload komutunu kullanarak config dosyasını yeniden yükleyebilirsiniz.

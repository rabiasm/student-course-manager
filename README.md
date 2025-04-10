# 🎓 Student Course Manager API

Bu proje, öğrencilerin ders ve not bilgilerini yönetmek amacıyla geliştirilmiş bir Java Spring Boot RESTful API uygulamasıdır. PostgreSQL veritabanı ile çalışır ve gerçek not sistemiyle uyumlu şekilde tasarlanmıştır.

---

## 🚀 Kullanılan Teknolojiler

- 💻 Java 17  
- 🌱 Spring Boot  
- 📚 Spring Data JPA  
- 🛢️ PostgreSQL  
- ☕ Maven  
- 🔁 Postman (API testleri için)  
- 🧠 Katmanlı Mimari (Controller - Service - Repository - Entity)

---

## ⚙️ Temel Özellikler

- Öğrenci ve ders kayıtları
- Öğrencilerin derslere kayıt işlemleri (Enrollment)
- Not (Grade) ekleme, listeleme, güncelleme ve silme
- Öğrenciye göre not listeleme
- Derse göre not listeleme
- Belirli bir öğrencinin, belirli dersteki notunu görüntüleme
- Gerçekçi harf notu sistemine uygun: `AA`, `BA`, `CC`, `FF`...

---

## 🔗 Örnek API Endpoint’leri

```http
GET    /grades/student/{studentId}
GET    /grades/course/{courseId}
GET    /grades/student/{studentId}/course/{courseId}
POST   /grades/{enrollmentId}

### GET http://localhost:8080/api/shape ✅
![image](https://github.com/user-attachments/assets/435ce3f2-f07e-4a78-91a5-7d73e09ce570)

### POST http://localhost:8080/api/shape ✅
![image](https://github.com/user-attachments/assets/a4bc2711-bdf9-4e3a-8c60-5cc3a5c90eba)

### GET http://localhost:8080/api/rectangle/752 ✅
![image](https://github.com/user-attachments/assets/42f01f81-2118-4852-ac44-85a977566def)

### DELETE http://localhost:8080/api/triangle/delete?id=502 ✅
![image](https://github.com/user-attachments/assets/d88f2f5f-9f90-47ef-a5cf-649b067a02fa)

### DELETE http://localhost:8080/api/triangle/delete?id=1 ❌
![image](https://github.com/user-attachments/assets/83a493c3-d1c8-4d90-a0e0-c1f5a3ea3114)

### PUT http://localhost:8080/api/rectangle/add ✅
```json
{
    "color": {
        "red": 255,
        "green": 0,
        "blue": 0,
        "alpha": 255
    },
    "width": 5.0,
    "height": 3.0
}
```
![image](https://github.com/user-attachments/assets/dc49158e-7830-4e68-8f9c-a755756f5a17)

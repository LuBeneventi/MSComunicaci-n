#Reseña
INSERT INTO `resena` (`calificacion`, `fecha_emision`, `id_cliente`, `id_producto`, `id_resena`, `comentario`)
VALUES (5, '2025-05-20', 101, 201, 1001, 'Excelente calidad, llegó antes de lo esperado.');

INSERT INTO `resena` (`calificacion`, `fecha_emision`, `id_cliente`, `id_producto`, `id_resena`, `comentario`)
VALUES (3, '2025-05-18', 102, 202, 1002, 'El producto es bueno, pero el empaque venía dañado.');

INSERT INTO `resena` (`calificacion`, `fecha_emision`, `id_cliente`, `id_producto`, `id_resena`, `comentario`)
VALUES (4, '2025-05-22', 103, 203, 1003, 'Buena relación calidad-precio, lo recomiendo.');

INSERT INTO `resena` (`calificacion`, `fecha_emision`, `id_cliente`, `id_producto`, `id_resena`, `comentario`)
VALUES (2, '2025-05-15', 104, 204, 1004, 'No cumplió con mis expectativas, esperaba mejor rendimiento.');

INSERT INTO `resena` (`calificacion`, `fecha_emision`, `id_cliente`, `id_producto`, `id_resena`, `comentario`)
VALUES (1, '2025-05-10', 105, 205, 1005, 'Muy mala experiencia, no lo volvería a comprar.');

{

"idCliente": 1,
"idProducto": 45,
"calificacion": 1,
"comentario": "No cumple con lo que dicen los anuncios"
}
##Solicitud
INSERT INTO `solicitud_soporte` (`fecha_creacion`, `id_cliente`, `id_soporte`, `titulo`, `contenido`, `estado`, `tipo`)
VALUES ('2025-05-20', 101, 2001, 'Problema con la entrega', 'El paquete no ha llegado desde hace 10 días.', 'ABIERTO', 'RECLAMO');

INSERT INTO `solicitud_soporte` (`fecha_creacion`, `id_cliente`, `id_soporte`, `titulo`, `contenido`, `estado`, `tipo`)
VALUES ('2025-05-21', 102, 2002, 'Error en facturación', 'Se me ha cobrado dos veces por el mismo pedido.', 'ABIERTO', 'RECLAMO');

INSERT INTO `solicitud_soporte` (`fecha_creacion`, `id_cliente`, `id_soporte`, `titulo`, `contenido`, `estado`, `tipo`)
VALUES ('2025-05-22', 103, 2003, 'Producto defectuoso', 'El artículo llegó roto y no funciona.', 'ABIERTO', 'RECLAMO');

INSERT INTO `solicitud_soporte` (`fecha_creacion`, `id_cliente`, `id_soporte`, `titulo`, `contenido`, `estado`, `tipo`)
VALUES ('2025-05-23', 104, 2004, 'No puedo iniciar sesión', 'Olvidé mi contraseña y no puedo restablecerla.', 'CERRADA', 'RECLAMO');

INSERT INTO `solicitud_soporte` (`fecha_creacion`, `id_cliente`, `id_soporte`, `titulo`, `contenido`, `estado`, `tipo`)
VALUES ('2025-05-24', 105, 2005, 'Consulta sobre garantía', '¿Cuánto tiempo de garantía tiene el producto que compré?', 'CERRADA', 'CONSULTA');


{
  "idCliente": 101,
  "titulo": "Problema con el producto",
  "contenido": "El producto llegó dañado.",
  "tipo": "RECLAMO"
}
{
  "idUsuario": 500,
  "contenido": "Lamentamos el inconveniente. Vamos a gestionar un cambio del producto."
}
{
  "idCliente": 101,
  "contenido": "Gracias, se aprecia la rapidez."
}

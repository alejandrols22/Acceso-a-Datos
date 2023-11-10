USE simulacro;

DELIMITER $$

CREATE PROCEDURE `CalculaPrecioIva2`(IN precio_base DECIMAL(10,2), OUT precio_con_iva DECIMAL(10,2))
BEGIN
  DECLARE tasa_iva DECIMAL(10,2);
  
  -- Suponiendo que la tasa del IVA es del 21%
  SET tasa_iva = 0.21;
  
  -- Calcula el precio con IVA incluido
  SET precio_con_iva = precio_base + (precio_base * tasa_iva);
END$$

DELIMITER ;



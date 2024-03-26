<%-- 
    Document   : RegistroUsuario
    Created on : 15 mar. 2024, 22:44:05
    Author     : Jonathan Flores
--%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
     
    <title>Registro de Usuarios</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style>
      
    </style>
</head>
<body>
    <div class="container">
        <div class="content">
            <h1>Registro de Usuarios</h1>
            <form id="registro">
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" required>
                </div>

                <div class="form-group">
                    <label for="apellido">Apellido:</label>
                    <input type="text" id="apellido" name="apellido" required>
                </div>

                <div class="form-group">
                    <label for="dui">DUI:</label>
                    <input type="text" id="dui" name="dui" required>
                </div>

                <div class="form-group">
                    <label for="telefono">Teléfono:</label>
                    <input type="text" id="telefono" name="telefono" required>
                </div>

                <div class="form-group">
                    <label for="correo">Correo:</label>
                    <input type="email" id="correo" name="correo" required>
                </div>

                <div class="form-group">
                    <label for="direccion">Dirección:</label>
                    <input type="text" id="direccion" name="direccion" required>
                </div>

                <div class="form-group">
                    <label for="estado">Estado:</label>
                    <select id="estado" name="estado" required>
                        <option value="activo">Activo</option>
                        <option value="inactivo">Inactivo</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="cargo">Cargo:</label>
                    <select id="cargo" name="cargo" required>
                        <option value="administrador">Administrador</option>
                        <option value="empleado">Empleado</option>
                        <option value="cliente">Cliente</option>
                    </select>
                </div>

                <button type="submit">Registrar</button>
            </form>

            <h2>Lista de Usuarios</h2>
            <table id="tablaUsuarios">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>DUI</th>
                        <th>Teléfono</th>
                        <th>Correo</th>
                        <th>Dirección</th>
                        <th>Estado</th>
                        <th>Cargo</th>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>

    <script src="js/RegistroUsuario.js" type="text/javascript">
 
    </script>
</body>
</html>

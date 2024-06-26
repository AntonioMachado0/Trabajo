<%-- 
    Document   : Registro
    Created on : 15 mar. 2024, 18:47:38
    Author     : Jonathan Flores
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Cliente</title>
     <script src="http://code.jquery.com/jquery-latest.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header bg-primary text-white">
                        <h4 class="mb-0">Registro de Cliente</h4>
                    </div>
                    <div class="card-body">
                        <form id="form1">
                            <div class="form-group">
                                <label for="nombre">Nombre:</label>
                                <input type="text" class="form-control" id="nombre" name="nombre" required>
                            </div>
                            <div class="form-group">
                                <label for="apellido">Apellido:</label>
                                <input type="text" class="form-control" id="apellido" name="apellido" required>
                            </div>
                            <div class="form-group">
                                <label for="telefono">Tel�fono:</label>
                                <input type="text" class="form-control"  id="telefono" name="telefono" maxlength="8"  required>
                            
                            </div>
                            <div class="form-group">
                                <label for="correo">Correo electr�nico:</label>
                                <input type="email" class="form-control" id="correo" name="correo" required>
                            </div>
                            <div class="form-group">
                                <label for="clave">Clave:</label>
                                <input type="password" class="form-control" id="clave" name="clave" required>
                            </div>
                            <button type="submit"  id="submit" class="btn btn-primary btn-block">Registrarse</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
   
    <script src="js/registro.js" type="text/javascript"></script>
</body>
</html>

package modelo;
import dao.ReservaDao;
import dao.UsuarioDao;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Reserva;

public class ImprimirDatosDao {

     public static void imprimirDatos(ArrayList<Reserva> reservasList) {
        System.out.println("Imprimiendo datos del DAO:");

        for (Reserva reserva : reservasList) {
            System.out.println("ID: " + reserva.getIdReserva());
            System.out.println("Fecha: " + reserva.getFecha());
            System.out.println("Hora: " + reserva.getHora());
            System.out.println("Nombre Cliente: " + reserva.getCliente().getNombre());
            System.out.println("Tipo de Corte: " + reserva.getCorte().getTipoCorte());
            System.out.println("--------------------------");
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Supongamos que ya has obtenido el ArrayList<Reserva> desde tu DAO
        ArrayList<Reserva> reservasList = obtenerDatosDesdeDao();

        // Llamada al método para imprimir los datos
        imprimirDatos(reservasList);
    }

    // Método ficticio para simular la obtención de datos desde el DAO
    private static ArrayList<Reserva> obtenerDatosDesdeDao() throws SQLException, ClassNotFoundException {
        // Aquí deberías llamar al método de tu DAO para obtener las reservas
        // Retorna la lista de reservas simulada para este ejemplo
        return new ReservaDao().obtenerReservasConDetalles();
    }

    /*
     public void imprimirUsuarios(ArrayList<Usuarios> usuariosList) {
        for (Usuarios usuario : usuariosList) {
            System.out.println("Nombre: " + usuario.getNombreusuario());
            System.out.println("Apellido: " + usuario.getApellidousuario());
            System.out.println("DUI: " + usuario.getDui());
            System.out.println("Teléfono: " + usuario.getTelefono());
            System.out.println("Estado: " + usuario.getEstado());
            System.out.println("Cargo: " + usuario.getCargo().getNombrecargo());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        UsuarioDao dao = new UsuarioDao();
       ImprimirDatosDao imprimir = new ImprimirDatosDao ();
        try {
            ArrayList<Usuarios> usuariosList = dao.obtenerUsuariosConCargos();
            imprimir.imprimirUsuarios(usuariosList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
}

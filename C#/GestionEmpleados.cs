using System;
using System.Collections.Generic;

class Empleado
{
    public string Nombre { get; set; }
    public int Edad { get; set; }
    public string Cargo { get; set; }

    public Empleado(string nombre, int edad, string cargo)
    {
        Nombre = nombre;
        Edad = edad;
        Cargo = cargo;
    }

    public virtual void MostrarInfo()
    {
        Console.WriteLine($"Nombre: {Nombre}, Edad: {Edad}, Cargo: {Cargo}");
    }
}

class Mecanico : Empleado
{
    public Mecanico(string nombre, int edad) : base(nombre, edad, "Mecánico") { }
}

class Asistente : Empleado
{
    public Asistente(string nombre, int edad) : base(nombre, edad, "Asistente") { }
}

class Recepcion : Empleado
{
    public Recepcion(string nombre, int edad) : base(nombre, edad, "Recepción") { }
}

class JefeVentas : Empleado
{
    public JefeVentas(string nombre, int edad) : base(nombre, edad, "Jefe de Ventas") { }
}

class ProgramaEmpleados
{
    static void Main(string[] args)
    {
        List<Empleado> empleados = new List<Empleado>();

        empleados.Add(new Mecanico("Juan", 30));
        empleados.Add(new Asistente("Laura", 25));
        empleados.Add(new Recepcion("Carlos", 28));
        empleados.Add(new JefeVentas("Marta", 40));

        Console.WriteLine("=== Lista de Empleados ===");
        foreach (Empleado emp in empleados)
        {
            emp.MostrarInfo();
        }
    }
}

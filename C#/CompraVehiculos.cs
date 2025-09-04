using System;
using System.Collections.Generic;

class Vehiculo
{
    public string Marca { get; set; }
    public double Precio { get; set; }

    public Vehiculo(string marca, double precio)
    {
        Marca = marca;
        Precio = precio;
    }

    public virtual void MostrarInfo()
    {
        Console.WriteLine($"Vehículo: {Marca}, Precio: {Precio}");
    }
}

class Carro : Vehiculo
{
    public Carro(string marca, double precio) : base(marca, precio) { }
}

class Camioneta : Vehiculo
{
    public Camioneta(string marca, double precio) : base(marca, precio) { }
}

class Avion : Vehiculo
{
    public Avion(string marca, double precio) : base(marca, precio) { }
}

class Bus : Vehiculo
{
    public Bus(string marca, double precio) : base(marca, precio) { }
}

class ProgramaVehiculos
{
    static void Main(string[] args)
    {
        List<Vehiculo> vehiculos = new List<Vehiculo>();

        vehiculos.Add(new Carro("Toyota", 50000));
        vehiculos.Add(new Camioneta("Chevrolet", 80000));
        vehiculos.Add(new Avion("Boeing", 2000000));
        vehiculos.Add(new Bus("Mercedes", 120000));

        Console.WriteLine("=== Vehículos disponibles ===");
        foreach (Vehiculo v in vehiculos)
        {
            v.MostrarInfo();
        }
    }
}

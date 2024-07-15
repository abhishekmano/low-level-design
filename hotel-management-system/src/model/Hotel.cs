using System.Reflection;
using hotel_management_system.interfaces;
using hotel_management_system.models;

public class Hotel
{
    public int Id { get; set; }
    public string Name { get; set; }

    public Address Address { get; set; }

    public List<Room> Rooms { get; set; }
    public List<RoomBooking> RoomBookings { get; set; }
}

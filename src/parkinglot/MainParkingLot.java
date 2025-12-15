package parkinglot;

import parkinglot.enums.*;
import parkinglot.model.*;

import java.math.BigDecimal;
import java.util.*;
import static parkinglot.utils.ParkinglotConstants.*;

public class MainParkingLot {
    private static Parkinglot parkinglot;
    public static void main(String[] args) {
        registerData();
        //Vehicle at Entry Gate "EN01"
        List<Ticket> tickets = new ArrayList<>();
        for(int i=0;i<4;i++){
            Vehicle vehicle = getRandomVehicle("VE00"+i);
            EntryGate entryGate = parkinglot.getEntryGateByNo("EN01");
            Ticket ticket = entryGate.issueTicket(vehicle, parkinglot);
            ticket.setEntryGateNo(entryGate.getGateNo());
            printEntryTicket(ticket);
            ticket.getSpot().setVehicle(vehicle); //Park Vehicle
            tickets.add(ticket);
        }
        //Vehicle at Entry Gate "EN02"
        System.out.println("\n*************Exiting Vehicle*******************");
        for(int i=0;i<2;i++){
            ExitGate exitGate = parkinglot.getExitGateByNo("EX02");//verify is the label exsir
            Ticket currentTicket =  tickets.get(i);
            BigDecimal amountPayable = exitGate.calculateCost(currentTicket);
            boolean received = exitGate.receivePayment(amountPayable, amountPayable);
            if(received){
                currentTicket.setAmountPaid(amountPayable);
                currentTicket.setExistGateNo(exitGate.getGateNo());
                exitGate.freeSpot(currentTicket.getSpot());
            }
            printExitTicket(currentTicket);
        }
    }

    private static void printExitTicket(Ticket ticket) {
        System.out.println("\nTicket No: "+ticket.getTicketNo()+
                "\nEntry Gate: "+ticket.getEntryGateNo()+
                "\nExit Gate: "+ticket.getExistGateNo()+
                "\nSpot No: "+ticket.getSpotNo()+
                "\nVehicle No: "+ticket.getVehicleNo()+
                "\nVehicle Type: "+ticket.getVehicle().getVehicleType()+
                "\nEntry Time: "+ticket.getEntryTime()+
                "\nAmount Paid: "+ticket.getAmountPaid()+
                "\nDuration: "+ticket.getDuration());
    }

    private static void printEntryTicket(Ticket ticket) {
        System.out.println("\nTicket No: "+ticket.getTicketNo()+
                "\nEntry Gate: "+ticket.getEntryGateNo()+
                "\nSpot No: "+ticket.getSpotNo()+
                "\nVehicle No: "+ticket.getVehicleNo()+
                "\nVehicle Type: "+ticket.getVehicle().getVehicleType()+
                "\nEntry Time: "+ticket.getEntryTime());
    }

    public static void  registerData(){
        parkinglot = new Parkinglot();
        Map<SpotType,List<Spot>> spots = new HashMap<>();
        List<EntryGate> entryGates = new ArrayList<>();
        List<ExitGate> exitGates = new ArrayList<>();
        //-----------------------------------------------------------
        //          Two Wheeler spots
        //-----------------------------------------------------------
        for (int i=0;i<10;i++){
            Spot twoWheelerSpot = new TwoWheelerSpot(i);
            if(spots.get(SpotType.TWO_WHELLER)!=null){
                spots.get(SpotType.TWO_WHELLER).add(twoWheelerSpot);
            }else{
                List<Spot> twoSpots = new ArrayList<>();
                twoSpots.add(twoWheelerSpot);
                spots.put(SpotType.TWO_WHELLER,twoSpots);
            }
            Spot fourWheelerSpot = new FourWheelerSpot(i);
        }
        //-----------------------------------------------------------
        //          Four Wheeler Spots
        //-----------------------------------------------------------
        for (int i=0;i<5;i++){
            Spot fourWheelerSpot = new FourWheelerSpot(i);
            if(spots.get(SpotType.FOUR_WHEELER)!=null){
                spots.get(SpotType.FOUR_WHEELER).add(fourWheelerSpot);
            }else{
                List<Spot> fourSpots = new ArrayList<>();
                fourSpots.add(fourWheelerSpot);
                spots.put(SpotType.FOUR_WHEELER,fourSpots);
            }
        }
        parkinglot.setSpots(spots);
        //-----------------------------------------------------------
        //          Entry Gates
        //-----------------------------------------------------------
        EntryGate entryGate1 = new EntryGate("EN01",true, GateStatus.CLOSED,STANDARD);
        EntryGate entryGate2 = new EntryGate("EN02",true, GateStatus.CLOSED,STANDARD);
        entryGates.add(entryGate1);
        entryGates.add(entryGate2);
        parkinglot.setEntryGates(entryGates);
        //-----------------------------------------------------------
        //          Exit Gates
        //-----------------------------------------------------------
        ExitGate exitGate1 = new ExitGate("EX01",true,GateStatus.CLOSED,STANDARD);
        ExitGate exitGate2 = new ExitGate("EX02",true, GateStatus.CLOSED,HOURS);
        exitGates.add(exitGate1);
        exitGates.add(exitGate2);
        parkinglot.setExitGates(exitGates);
    }

    public static Vehicle getRandomVehicle(String vehicleNo){
        VehicleType[] vehicleTypes = VehicleType.values();
        Integer value = (int) (Math.random() * 1000);
        return new Vehicle(vehicleNo,vehicleTypes[value%2]);
    }
}

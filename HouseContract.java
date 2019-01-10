package java_bootcamp;

import net.corda.core.contracts.Command;
import net.corda.core.contracts.CommandData;
import net.corda.core.contracts.Contract;
import net.corda.core.identity.Party;
import net.corda.core.transactions.LedgerTransaction;
import org.jetbrains.annotations.NotNull;

import java.rmi.registry.Registry;
import java.security.PublicKey;
import java.util.List;

public class HouseContract implements Contract {
    @Override
    public void verify(@NotNull LedgerTransaction tx) throws IllegalArgumentException {
        if(tx.getCommands().size()!=1) {
            throw new IllegalArgumentException("One comand");
        }
        Command command = tx.getCommand(0);
        List<PublicKey> signers = command.getSigners();
        CommandData data = command.getValue();
        if(data instanceof Transfer){}
        else if(data instanceof Register){
            if(tx.getInputStates().size()!=0){
                throw new IllegalArgumentException("Illegal Command");
            }
            if(tx.getOutputStates().size()!=1){
                throw new IllegalArgumentException("Illegal Command");
            }
            if(!(tx.getOutputStates().get(0) instanceof HouseState)){
                throw new IllegalArgumentException("Illegal Command");
            }

        }
        else{
            throw new IllegalArgumentException("Illegal Command");
        }
    }
    public class Transfer implements CommandData{

    }
    public class Register implements CommandData{

    }
}

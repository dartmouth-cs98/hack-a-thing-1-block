package java_bootcamp;

import net.corda.core.contracts.Command;
import net.corda.core.contracts.CommandData;
import net.corda.core.contracts.Contract;
import net.corda.core.contracts.ContractState;
import net.corda.core.transactions.LedgerTransaction;
import org.jetbrains.annotations.NotNull;

import static net.corda.core.contracts.ContractsDSL.requireThat;

/* Our contract, governing how our state will evolve over time.
 * See src/main/java/examples/ArtContract.java for an example. */
public class TokenContract implements Contract {
    public static String ID = "java_bootcamp.TokenContract";

    @Override
    public void verify(@NotNull LedgerTransaction tx) throws IllegalArgumentException {
        if(tx.getInputStates().size()!=0){
            throw new IllegalArgumentException();
        }
        if(tx.getOutputStates().size()!=1){
            throw new IllegalArgumentException();
        }
        if(tx.getCommands().size()!=1){
            throw new IllegalArgumentException();
        }
        if(tx.getOutputStates().get(0) instanceof TokenState){
            throw new IllegalArgumentException();
        }
        TokenState tokenState = (TokenState)tx.getOutputStates().get(0);
        if(tokenState.getAmount()<=0){
            throw new IllegalArgumentException();
        }
        if (tx.getCommand(0).getValue() instanceof Commands.Issue){
            throw new IllegalArgumentException();
        }
        if (!tx.getCommand(0).getSigners().contains(tokenState.getIssuer())) {
            throw new IllegalArgumentException();
        }
        
    }

    public interface Commands extends CommandData {
        class Issue implements Commands { }
    }
}
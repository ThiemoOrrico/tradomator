import {Switch, Route} from "react-router-dom";
import {Box} from "@mui/material";
import TopAppBar from "./components/TopAppBar";
import useGeckoCoins from "./hooks/useGeckoCoins";
import useWalletBalances from "./hooks/useWalletBalances"
import LowerButtonNavBar from "./components/LowerButtonNavBar";
import CoingeckoOverview from "./components/CoingeckoOverview";
import WalletOverview from "./components/WalletOverview";
import Loginpage from "./pages/Loginpage";
import AuthProvider from "./context/AuthProvider";


export default function App() {


    const {wallet} = useWalletBalances()
    const {coins} = useGeckoCoins()



    return (

        <div>
<AuthProvider>
            <TopAppBar/>

            <Box sx={{width: '100%', mt: 8}}>
                <Switch>

                    <Route exact path="/">
                        <CoingeckoOverview coins={coins}/>

                    </Route>

                    <Route path="/wallet">
                        <WalletOverview wallet={wallet}/>

                    </Route>

                    <Route path="/login">
                        <Loginpage/>
                    </Route>

                </Switch>
            </Box>

            <LowerButtonNavBar/>
</AuthProvider>
        </div>


    );
}

import { BrowserRouter, Switch, Route } from "react-router-dom";
import Orders from "./Orders";
import NavBar from "./NavBar";
import Home from "./Home";

function Routes() {
    return (
        <BrowserRouter>
        <NavBar />
            <Switch>
                <Route path="/orders">
                    <Orders />
                </Route>
                <Route path="/">
                    <Home />
                </Route>
            </Switch>
        </BrowserRouter>
    )
}

export default Routes;
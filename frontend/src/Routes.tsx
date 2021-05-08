import DashBoard from 'assets/pages/Dashboard';
import Home from 'assets/pages/Home';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

const Routes = () => {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" exact>
                    <Home />
                </Route>
                <Route path="/dashboard" exact>
                    <DashBoard />
                </Route>
            </Switch>

        </BrowserRouter>
    );
}

export default Routes;

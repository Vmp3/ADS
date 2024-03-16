import './App.css';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import Home from './Components/Pages/Home';
import Produtos from './Components/Pages/Produtos';

function App() {
  const myRouter = createBrowserRouter([
    {path: '/', element: <Home/>},
    {path: '/produtos', element: <Produtos/> }
  ]);
  return (
    <RouterProvider router={myRouter}/>
  );
}

export default App;

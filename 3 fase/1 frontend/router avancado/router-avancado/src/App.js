import './App.css';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import Home from './Components/Pages/Home';
import Produtos from './Components/Pages/Produtos';
import RootLayout from './Components/Pages/RootLayout';
import Clientes from './Components/Pages/Clientes';
import Erro404 from './Components/Pages/Erro404';
import DetalharProduto from './Components/Pages/DetalharProduto';
import { Children } from 'react';
import MainHeader from './Components/MainHeader';


function App() {
  const myRouter = createBrowserRouter([
    {
      path: '/', element: <RootLayout/>,
      errorElement: <Erro404/>,
      children: [ 
      {path: '/', element: <Home/>},
      {path: '/produtos', element: <Produtos/>},
      {path: '/clientes', element: <Clientes/>},
      {path: '/produtos/:produtoId', element: <DetalharProduto/>},
      
      
    ]
  }
    
  ]);
  return (
    <RouterProvider router={myRouter}/>
  );
}

export default App;

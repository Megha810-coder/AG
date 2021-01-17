interface NavAttributes {
  [propName: string]: any;
}
interface NavWrapper {
  attributes: NavAttributes;
  element: string;
}
interface NavBadge {
  text: string;
  variant: string;
}
interface NavLabel {
  class?: string;
  variant: string;
}

export interface NavData {
  name?: string;
  url?: string;
  icon?: string;
  badge?: NavBadge;
  title?: boolean;
  children?: NavData[];
  variant?: string;
  attributes?: NavAttributes;
  divider?: boolean;
  class?: string;
  label?: NavLabel;
  wrapper?: NavWrapper;
}

export const navItems: NavData[] = [
  {
    name: 'Dashboard',
    url: '/dashboard',
    icon: 'icon-speedometer',
    badge: {
      variant: 'info',
      text: 'NEW'
    }
  },
  {
  name: 'MAIN',
  url: '/billing',
  icon: 'icon-list',
  children: [
    {
      name: 'PRODUCT',
      url: '/billing/Product'
     
    },
    // {
    //   name: 'PURCHASE BILL',
    //   url: '/billing/Purchasebill'
     
    // },
    // {
    //   name: 'CUSTOMER',
    //   url: '/billing/customer'
     
    // },
    {
      name: 'VENDORS',
      url: '/billing/vendors'
     
    },
    // {
    //   name: 'QUOTATION',
    //   url: '/billing/quotation'
     
    // },
    // {
    //   name: 'INVOICE',
    //   url: '/billing/invoice'
     
    // },
    // {
    //   name: 'INVOICE',
    //   url: '/billing/customer-bill'
     
    // },
    {
      name: 'INVOICE',
      url: '/billing/invoice1'
     
    },
    // {
    //   name: 'REPORTS',
    //   url: '/billing/report'
     
    // },
    // {
    //   name: 'CUSTOMER REPORTS',
    //   url: '/billing/customerreport'
     
    // },
    
    
    
  ]
},
{
  name: 'REPORT',
  url: '/allreport',
  icon: 'icon-list',
  children: [
    {
      name: 'CUSTOMER REPORT',
      url: '/allreport/AllCustomer'
     
    },
    {
      name: 'ALL CUSTOMER REPORT',
      url: '/allreport/Customer'
     
    },
    {
      name: 'PRODUCT REPORT',
      url: '/allreport/Product'
     
    },
  ]
},
  
];

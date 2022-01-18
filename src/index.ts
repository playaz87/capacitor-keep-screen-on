import { registerPlugin } from '@capacitor/core';

import type { KeepScreenOnPlugin } from './definitions';

const KeepScreenOn = registerPlugin<KeepScreenOnPlugin>('KeepScreenOn', {
  web: () => import('./web').then(m => new m.KeepScreenOnWeb()),
});

export * from './definitions';
export { KeepScreenOn };

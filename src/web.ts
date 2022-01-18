import { WebPlugin } from '@capacitor/core';

import type { KeepScreenOnPlugin } from './definitions';

export class KeepScreenOnWeb extends WebPlugin implements KeepScreenOnPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
